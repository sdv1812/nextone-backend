import { ApiProperty } from '@nestjs/swagger';

export class CreateQuestionDto {
  @ApiProperty({ example: 'q1' })
  readonly id: string;

  @ApiProperty({ example: 'What is the capital of France?' })
  readonly text: string;

  @ApiProperty({ example: 'Berlin' })
  readonly optionA: string;

  @ApiProperty({ example: 'Madrid' })
  readonly optionB: string;

  @ApiProperty({ example: 'Paris' })
  readonly optionC: string;

  @ApiProperty({ example: 'Rome' })
  readonly optionD: string;

  @ApiProperty({ example: 'C' })
  readonly correctOption: string;

  @ApiProperty({ example: 'Paris is the capital of France.' })
  readonly explanation?: string;

  @ApiProperty({ example: 'Geography' })
  readonly category?: string;

  @ApiProperty({ example: 'Easy' })
  readonly difficulty?: string;

  @ApiProperty({ example: '2025-08-03T00:00:00.000Z' })
  readonly createdAt?: Date;
}
