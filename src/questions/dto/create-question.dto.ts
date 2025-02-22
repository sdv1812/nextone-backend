export class CreateQuestionDto {
  readonly id: string;
  readonly text: string;
  readonly optionA: string;
  readonly optionB: string;
  readonly optionC: string;
  readonly optionD: string;
  readonly correctOption: string;
  readonly explanation?: string;
  readonly category?: string;
  readonly difficulty?: string;
  readonly createdAt?: Date;
}
