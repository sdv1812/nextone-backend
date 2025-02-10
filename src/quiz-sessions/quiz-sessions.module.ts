import { Module } from '@nestjs/common';
import { QuizSessionsService } from './quiz-sessions.service';
import { QuizSessionsController } from './quiz-sessions.controller';

@Module({
  controllers: [QuizSessionsController],
  providers: [QuizSessionsService],
})
export class QuizSessionsModule {}
