import { Module } from '@nestjs/common';
import { MongooseModule } from '@nestjs/mongoose';
import { QuestionsModule } from './questions/questions.module';
import { UsersModule } from './users/users.module';
import { QuizSessionsModule } from './quiz-sessions/quiz-sessions.module';

@Module({
  imports: [
    MongooseModule.forRoot(
      process.env.MONGO_URI ||
        'mongodb+srv://nextonedb-cluster.uxcq4.mongodb.net/?retryWrites=true&w=majority&appName=nextonedb-cluster',
      {
        user: process.env.MONGO_USER || 'admin',
        pass: process.env.MONGO_PASSWORD || 'admin',
      },
    ),
    QuestionsModule,
    UsersModule,
    QuizSessionsModule,
  ],
})
export class AppModule {}
