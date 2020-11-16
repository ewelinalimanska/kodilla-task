package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloService trelloService;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {


 //       22.2
//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
//
//        trelloBoards.stream()
//                .filter(n -> n.getId() != null && !n.getId().isEmpty())
//                .filter(n -> n.getName() != null && !n.getName().isEmpty())
//                .filter(n -> n.getName().contains("Kodilla"));
//
//
//        trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
//
//    }

        // GET request
//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
//
//        trelloBoards.forEach(trelloBoardDto -> {
//
//            System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
//
//            System.out.println("This board contains lists: ");
//
//            trelloBoardDto.getLists().forEach(trelloList ->
//                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
//
//        });

//        return trelloClient.getTrelloBoards();
        return trelloService.fetchTrelloBoard();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto){

      //  return trelloClient.createNewCard(trelloCardDto);
//        return trelloService.createdTrelloCard(trelloCardDto);
        return trelloService.createdTrelloCard(trelloCardDto);
    }
}
