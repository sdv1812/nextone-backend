// src/questions/schemas/question.schema.ts
import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import { Document } from 'mongoose';

export type QuestionDocument = Question & Document;

@Schema({ timestamps: true })
export class Question {
  @Prop({ required: true })
  text: string;

  @Prop({ type: [{ id: String, text: String }], required: true })
  options: { id: string; text: string }[];

  @Prop({ type: [String], required: true })
  correctOptions: string[];

  @Prop()
  explanation: string;

  @Prop()
  category: string;

  @Prop()
  difficulty: string;
}

export const QuestionSchema = SchemaFactory.createForClass(Question);
