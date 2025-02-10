import { Test, TestingModule } from '@nestjs/testing';
import { QuizSessionsService } from './quiz-sessions.service';

describe('QuizSessionsService', () => {
  let service: QuizSessionsService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [QuizSessionsService],
    }).compile();

    service = module.get<QuizSessionsService>(QuizSessionsService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
