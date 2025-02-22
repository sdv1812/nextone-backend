export class CreateQuizSessionDto {
  readonly userId: string;
  readonly questionResponses: {
    questionId: string;
    selectedOptions: string;
    correctOptions: string;
    isCorrect: boolean;
    answeredAt: Date;
  }[];
  readonly score: number;
  readonly startedAt?: Date;
  readonly completedAt?: Date;
}
