export class CreateQuestionDto {
  readonly text: string;
  readonly options: { id: string; text: string }[];
  readonly correctOptions: string[];
  readonly explanation?: string;
  readonly category?: string;
  readonly difficulty?: string;
}
