import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import { Document } from 'mongoose';

export type QuestionDocument = Question & Document;

@Schema({ timestamps: true })
export class Question {
  @Prop({ required: true })
  text: string;

  @Prop({ type: String, required: true })
  optionA: string;

  @Prop({ type: String, required: true })
  optionB: string;

  @Prop({ type: String, required: true })
  optionC: string;

  @Prop({ type: String, required: true })
  optionD: string;

  @Prop({ type: String, required: true })
  correctOption: string;

  @Prop()
  explanation?: string;

  @Prop({ required: true })
  category: string;

  @Prop()
  difficulty?: string;

  @Prop()
  createdAt?: Date;
}

export const QuestionSchema = SchemaFactory.createForClass(Question);
