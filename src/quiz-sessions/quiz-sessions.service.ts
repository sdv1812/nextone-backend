import { Injectable } from '@nestjs/common';
import { InjectModel } from '@nestjs/mongoose';
import { Model } from 'mongoose';
import { QuizSession } from './entities/quiz-session.entity';
import { CreateQuizSessionDto } from './dto/create-quiz-session.dto';

@Injectable()
export class QuizSessionsService {
  constructor(
    @InjectModel(QuizSession.name) private quizSessionModel: Model<QuizSession>,
  ) {}

  async create(
    createQuizSessionDto: CreateQuizSessionDto,
  ): Promise<QuizSession> {
    const createdSession = new this.quizSessionModel(createQuizSessionDto);
    return createdSession.save();
  }

  async findAll(): Promise<QuizSession[]> {
    return this.quizSessionModel.find().exec();
  }

  async findOne(id: string): Promise<QuizSession | null> {
    return this.quizSessionModel.findById(id).exec();
  }
}
