package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//@RunWith(MockitoJUnitRunner.class)
class TrelloMapperTest {

//    @InjectMocks
    public TrelloMapper trelloMapper = new TrelloMapper();

//    @Mock
//    private TrelloBoardDto trelloBoardDto


    @Test
    public void testMapToBoards(){

        //given
        List<TrelloListDto> dtoLists = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("boardDto", "1", dtoLists);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);

        //when
        List<TrelloBoard> boards = trelloMapper.mapToBoards(trelloBoardDtos);

        //then
        assertEquals(1, boards.size());
        assertEquals("boardDto", boards.get(0).getName());//z pierwszej pozycji listy
        assertEquals("1", boards.get(0).getId());
        assertEquals(0, boards.get(0).getLists().size());

    }

    @Test
    public void testMapToBoardsDto(){

        //given
        List<TrelloList> list = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("board","1", list);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        //when
        List<TrelloBoardDto> boardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //then
        assertEquals(1, boardDtos.size());
        assertEquals("board", boardDtos.get(0).getName());
        assertEquals("1", boardDtos.get(0).getId());//pomylona kolejność id i name
        assertEquals(0, boardDtos.get(0).getLists().size());
    }

    @Test
    public void testMapToList(){

        //given
        List<TrelloListDto> dtoList = new ArrayList<>();

        //when
        List<TrelloList> lists = trelloMapper.mapToList(dtoList);

        //then
        assertEquals(0, lists.size());
    }

    @Test
    public void testMapToListDto(){

        //given
        List<TrelloList> list = new ArrayList<>();

        //when
        List<TrelloListDto> dtoList = trelloMapper.mapToListDto(list);

        //then
        assertEquals(0, dtoList.size());
    }

    @Test
    public void testMapToCard(){

        //given
        TrelloCardDto cardDto = new TrelloCardDto("card", "description_1", "top", "1");

        //when
        TrelloCard card = trelloMapper.mapToCard(cardDto);

        //then
        assertEquals("card", cardDto.getName());
        assertEquals("description_1", cardDto.getDescription());
        assertEquals("top", cardDto.getPos());
        assertEquals("1", cardDto.getListId());
    }

    @Test
    public void testMapToCardDto(){

        //given
        TrelloCard trelloCard = new TrelloCard("cardDto", "description_1", "top", "1");

        //when
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(trelloCard);

        //then
        assertEquals("cardDto", cardDto.getName());
        assertEquals("description_1", cardDto.getDescription());
        assertEquals("top", cardDto.getPos());
        assertEquals("1", cardDto.getListId());
    }
}