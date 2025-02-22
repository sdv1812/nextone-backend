// src/questions/questions.service.ts
import { Injectable } from '@nestjs/common';
import { InjectModel } from '@nestjs/mongoose';
import { Model } from 'mongoose';
import { Question } from './entities/question.entity';
import { CreateQuestionDto } from './dto/create-question.dto';

@Injectable()
export class QuestionsService {
  constructor(
    @InjectModel(Question.name) private questionModel: Model<Question>,
  ) {}

  async create(
    createQuestionDto: CreateQuestionDto,
  ): Promise<CreateQuestionDto> {
    const createdQuestion = new this.questionModel(createQuestionDto);
    const question = await createdQuestion.save();
    return {
      id: question._id.toString(),
      text: question.text,
      optionA: question.optionA,
      optionB: question.optionB,
      optionC: question.optionC,
      optionD: question.optionD,
      correctOption: question.correctOption,
      explanation: question.explanation,
      category: question.category,
      difficulty: question.difficulty,
      createdAt: question.createdAt,
    };
  }

  async findAll(): Promise<CreateQuestionDto[]> {
    const questions = await this.questionModel.find().exec();
    return questions.map((question) => ({
      id: question._id.toString(),
      text: question.text,
      optionA: question.optionA,
      optionB: question.optionB,
      optionC: question.optionC,
      optionD: question.optionD,
      correctOption: question.correctOption,
      explanation: question.explanation,
      category: question.category,
      difficulty: question.difficulty,
      createdAt: question.createdAt,
    }));
  }

  async findOne(id: string): Promise<Question | null> {
    return this.questionModel.findById(id).exec();
  }
}
