import { Injectable } from '@nestjs/common';
import { CreateQuizSessionDto } from './dto/create-quiz-session.dto';
import { UpdateQuizSessionDto } from './dto/update-quiz-session.dto';

@Injectable()
export class QuizSessionsService {
  create(createQuizSessionDto: CreateQuizSessionDto) {
    return 'This action adds a new quizSession';
  }

  findAll() {
    return `This action returns all quizSessions`;
  }

  findOne(id: number) {
    return `This action returns a #${id} quizSession`;
  }

  update(id: number, updateQuizSessionDto: UpdateQuizSessionDto) {
    return `This action updates a #${id} quizSession`;
  }

  remove(id: number) {
    return `This action removes a #${id} quizSession`;
  }
}
