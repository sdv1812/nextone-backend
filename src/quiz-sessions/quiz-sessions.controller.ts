// src/quiz-sessions/quiz-sessions.controller.ts
import { Controller, Get, Post, Body, Param } from '@nestjs/common';
import { QuizSessionsService } from './quiz-sessions.service';
import { CreateQuizSessionDto } from './dto/create-quiz-session.dto';

@Controller('quiz-sessions')
export class QuizSessionsController {
  constructor(private readonly quizSessionsService: QuizSessionsService) {}

  @Post()
  async create(@Body() createQuizSessionDto: CreateQuizSessionDto) {
    return this.quizSessionsService.create(createQuizSessionDto);
  }

  @Get()
  async findAll() {
    return this.quizSessionsService.findAll();
  }

  @Get(':id')
  async findOne(@Param('id') id: string) {
    return this.quizSessionsService.findOne(id);
  }
}
