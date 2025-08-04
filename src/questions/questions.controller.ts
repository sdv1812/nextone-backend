import {
  Controller,
  Get,
  Post,
  Body,
  Param,
  UploadedFiles,
  UseInterceptors,
  Query,
} from '@nestjs/common';
import { QuestionsService } from './questions.service';
import { CreateQuestionDto } from './dto/create-question.dto';
import { FilesInterceptor } from '@nestjs/platform-express';
import { S3Service } from '../common/s3.service';
import { ApiBody, ApiConsumes, ApiQuery } from '@nestjs/swagger';
import { FileCategory } from '../common/enums';

@Controller('questions')
export class QuestionsController {
  constructor(
    private readonly questionsService: QuestionsService,
    private readonly s3Service: S3Service,
  ) {}

  @Post()
  async create(
    @Body() createQuestionDto: CreateQuestionDto,
  ): Promise<CreateQuestionDto> {
    return this.questionsService.create(createQuestionDto);
  }

  @Get()
  async findAll() {
    return this.questionsService.findAll();
  }

  @Get(':id')
  async findOne(@Param('id') id: string) {
    return this.questionsService.findOne(id);
  }

  @ApiConsumes('multipart/form-data')
  @ApiBody({
    description: 'Upload images for question explanations',
    schema: {
      type: 'object',
      properties: {
        files: {
          type: 'array',
          items: {
            type: 'string',
            format: 'binary',
          },
        },
      },
    },
  })
  @ApiQuery({
    name: 'fileCategory',
    required: false,
    description: 'Category of the files being uploaded',
    enum: FileCategory,
    example: FileCategory.EXPLANATION,
  })
  @UseInterceptors(FilesInterceptor('files'))
  @Post('media/upload')
  async uploadImages(
    @UploadedFiles() files: Express.Multer.File[],
    @Query('fileCategory')
    fileCategory: FileCategory = FileCategory.EXPLANATION,
  ): Promise<{ urls: string[] }> {
    const urls = await this.s3Service.uploadFiles(files, fileCategory);
    return { urls };
  }
}
