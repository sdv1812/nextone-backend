import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { QuizSessionsService } from './quiz-sessions.service';
import { CreateQuizSessionDto } from './dto/create-quiz-session.dto';
import { UpdateQuizSessionDto } from './dto/update-quiz-session.dto';

@Controller('quiz-sessions')
export class QuizSessionsController {
  constructor(private readonly quizSessionsService: QuizSessionsService) {}

  @Post()
  create(@Body() createQuizSessionDto: CreateQuizSessionDto) {
    return this.quizSessionsService.create(createQuizSessionDto);
  }

  @Get()
  findAll() {
    return this.quizSessionsService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.quizSessionsService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateQuizSessionDto: UpdateQuizSessionDto) {
    return this.quizSessionsService.update(+id, updateQuizSessionDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.quizSessionsService.remove(+id);
  }
}
