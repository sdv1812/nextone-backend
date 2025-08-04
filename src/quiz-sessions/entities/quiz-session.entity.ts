import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import { Document, Types } from 'mongoose';

export type QuizSessionDocument = QuizSession & Document;

@Schema({ timestamps: true })
export class QuizSession {
  @Prop({ type: () => Types.ObjectId, ref: 'User', required: true })
  userId: Types.ObjectId;

  @Prop({
    type: [
      {
        questionId: { type: Types.ObjectId, ref: 'Question', required: true },
        selectedOptions: { type: String },
        correctOptions: { type: String },
        isCorrect: { type: Boolean },
        answeredAt: { type: Date },
      },
    ],
    default: [],
  })
  questionResponses: {
    questionId: Types.ObjectId;
    selectedOptions: string;
    correctOptions: string;
    isCorrect: boolean;
    answeredAt: Date;
  }[];

  @Prop()
  score: number;

  @Prop({ default: Date.now })
  startedAt: Date;

  @Prop()
  completedAt: Date;
}

export const QuizSessionSchema = SchemaFactory.createForClass(QuizSession);
