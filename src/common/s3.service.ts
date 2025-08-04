import { Injectable } from '@nestjs/common';
import { S3Client, PutObjectCommand } from '@aws-sdk/client-s3';
import { v4 as uuidv4 } from 'uuid';
import { FileCategory } from './enums';

@Injectable()
export class S3Service {
  private s3: S3Client;
  private bucketName = process.env.AWS_S3_BUCKET || 'nextone-media';

  constructor() {
    this.s3 = new S3Client({
      region: process.env.AWS_REGION || 'us-east-1',
    });
  }

  async uploadFiles(files: Express.Multer.File[], fileCategory: FileCategory): Promise<string[]> {
    const uploadPromises = files.map(async (file, _idx) => {
      const key = `${fileCategory}/${uuidv4()}-${file.originalname}`;
      await this.s3.send(
        new PutObjectCommand({
          Bucket: this.bucketName,
          Key: key,
          Body: file.buffer,
          ContentType: file.mimetype,
        })
      );
      return `https://${this.bucketName}.s3.amazonaws.com/${key}`;
    });
    return Promise.all(uploadPromises);
  }
}
