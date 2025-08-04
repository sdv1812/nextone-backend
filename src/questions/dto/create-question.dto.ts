import { ApiProperty } from '@nestjs/swagger';

export class CreateQuestionDto {
  readonly id: string;

  @ApiProperty({ example: 'What is the capital of France?' })
  readonly text: string;

  @ApiProperty({ example: 'Berlin' })
  readonly optionA: string;

  @ApiProperty({ example: 'Madrid' })
  readonly optionB: string;

  @ApiProperty({ example: 'Paris' })
  readonly optionC: string;

  @ApiProperty({ example: 'Rome' })
  readonly optionD: string;

  @ApiProperty({ example: 'C' })
  readonly correctOption: string;

  @ApiProperty({
    example: 'Paris is the capital of France. See {img1} for a map.',
  })
  readonly explanation?: string;

  @ApiProperty({
    example: [
      'https://s3.amazonaws.com/bucket/image1.jpg',
      'https://s3.amazonaws.com/bucket/image2.jpg',
    ],
    description:
      'S3 URLs for images used in the explanation. Use {img1}, {img2}, etc. as placeholders in the explanation text.',
    required: false,
    type: [String],
  })
  readonly explanationImages?: string[];

  @ApiProperty({ example: 'Geography' })
  readonly category?: string;

  @ApiProperty({ example: 'Easy' })
  readonly difficulty?: string;

  readonly createdAt?: Date;
}
