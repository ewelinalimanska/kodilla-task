package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.AdminConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    } //przy mockach bez springa

    @Test
    public void shouldFetchTrelloBoards() {

        //given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();

        //when
        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoardDtos);
        List<TrelloBoardDto> list = trelloService.fetchTrelloBoards();

        //then
        assertEquals(0, list.size());
    }

    @Test
    public void shouldCreatedCard() {

        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test_name", "test_descr", "test_pos", "1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "test_name", "url");

        //when
        when(trelloService.createdTrelloCard(trelloCardDto)).thenReturn(createdTrelloCardDto);
        CreatedTrelloCardDto newCard = trelloService.createdTrelloCard(trelloCardDto);

        //then
        assertEquals("test_name", newCard.getName());
        assertEquals("1", newCard.getId());
        assertEquals("url", newCard.getShortUrl());
    }
}