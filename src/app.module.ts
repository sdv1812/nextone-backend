import { Module } from '@nestjs/common';
import { MongooseModule } from '@nestjs/mongoose';
import { QuestionsModule } from './questions/questions.module';
import { UsersModule } from './users/users.module';
import { QuizSessionsModule } from './quiz-sessions/quiz-sessions.module';

@Module({
  imports: [
    // Adjust the MongoDB connection string as needed
    MongooseModule.forRoot(
      process.env.MONGO_URI || 'mongodb://host.docker.internal:27017/nextoneDb',
    ),
    QuestionsModule,
    UsersModule,
    QuizSessionsModule,
  ],
})
export class AppModule {}
