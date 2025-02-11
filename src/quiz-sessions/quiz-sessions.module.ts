// src/quiz-sessions/quiz-sessions.module.ts
import { Module } from '@nestjs/common';
import { MongooseModule } from '@nestjs/mongoose';
import { QuizSessionsController } from './quiz-sessions.controller';
import { QuizSessionsService } from './quiz-sessions.service';
import { QuizSession, QuizSessionSchema } from './entities/quiz-session.entity';

@Module({
  imports: [
    MongooseModule.forFeature([
      { name: QuizSession.name, schema: QuizSessionSchema },
    ]),
  ],
  controllers: [QuizSessionsController],
  providers: [QuizSessionsService],
})
export class QuizSessionsModule {}
