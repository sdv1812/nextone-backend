import { Module } from '@nestjs/common';
import { MongooseModule } from '@nestjs/mongoose';
import { QuestionsModule } from './questions/questions.module';
import { UsersModule } from './users/users.module';
import { QuizSessionsModule } from './quiz-sessions/quiz-sessions.module';

console.log('MONGO_URI:', process.env.MONGO_URI);
console.log('MONGO_USER:', process.env.MONGO_USER);
console.log('MONGO_PASSWORD:', process.env.MONGO_PASSWORD);

@Module({
  imports: [
    MongooseModule.forRoot(process.env.MONGO_URI ?? '', {
      user: process.env.MONGO_USER,
      pass: process.env.MONGO_PASSWORD,
    }),
    QuestionsModule,
    UsersModule,
    QuizSessionsModule,
  ],
})
export class AppModule {}
