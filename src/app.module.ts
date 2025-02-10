import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { QuestionsModule } from './questions/questions.module';
import { QuizSessionsModule } from './quiz-sessions/quiz-sessions.module';
import { UsersModule } from './users/users.module';

@Module({
  imports: [QuestionsModule, UsersModule, QuizSessionsModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
