package com.game.controller;

import com.game.entity.Player;
import com.game.entity.Profession;
import com.game.entity.Race;
import com.game.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                                                                                                         // Сочетание аннотации @Controller и @ResponseBody. Помечаем контролер, ничего необучного.
@RequestMapping("/rest")                                                                                             // Аннотация используется для сопоставления веб-запросов с методами контроллера Spring.
public class PlayerController {

    private final PlayerService playerService;
    @Autowired                                                                                                          // Используя эту аннотацию, не нужно заботиться о том, как лучше всего передать классу или bean'у экземпляр другого bean'a. Фреймворк Spring сам найдет нужный bean и подставит его значение в свойство.
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

//--------------------------------------- F U N C T I O N S ------------------------------------------------------------

    @GetMapping("/players")                                                                                           // Это составленная аннотация, которая действует как ярлык для @RequestMapping.
    public List<Player> getPlayersList(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "title", required = false) String title,
                                       @RequestParam(value = "race", required = false) Race race,
                                       @RequestParam(value = "profession", required = false)Profession profession,
                                       @RequestParam(value = "after", required = false) Long after,
                                       @RequestParam(value = "before", required = false) Long before,
                                       @RequestParam(value = "banned", required = false)Boolean banned,
                                       @RequestParam(value = "minExperience", required = false) Integer minExperience,
                                       @RequestParam(value = "maxExperience", required = false) Integer maxExperience,
                                       @RequestParam(value = "minLevel", required = false) Integer minLevel,
                                       @RequestParam(value = "maxLevel", required = false) Integer maxLevel,
                                       @RequestParam(defaultValue = "ID", value = "order") PlayerOrder order,
                                       @RequestParam(defaultValue = "0", value = "pageNumber") Integer pageNumber,
                                       @RequestParam(defaultValue = "3", value = "pageSize") Integer pageSize
    ) {
        List<Player> resultList = playerService.getFilteredPlayers(name, title, race, profession, after, before, banned, minExperience,
                maxExperience, minLevel, maxLevel);
        return playerService.getSortedPlayers(resultList, pageNumber, pageSize, order);
    }


    @GetMapping("/players/count")                                                                                     // Это составленная аннотация, которая действует как ярлык для @RequestMapping.
    public Integer GetPlayersCount(@RequestParam(value="name", required = false) String name,                            // Аннотация может использоваться для извлечения параметров запроса в методе обработчика.
                                   @RequestParam(value = "title", required = false) String title,
                                   @RequestParam(value = "race", required = false) Race race,
                                   @RequestParam(value = "profession", required = false) Profession profession,
                                   @RequestParam(value = "after", required = false) Long after,
                                   @RequestParam(value = "before", required = false) Long before,
                                   @RequestParam(value = "banned", required = false) Boolean banned,
                                   @RequestParam(value = "minExperience", required = false) Integer minExperience,
                                   @RequestParam(value = "maxExperience", required = false) Integer maxExperience,
                                   @RequestParam(value = "minLevel", required = false) Integer minLevel,
                                   @RequestParam(value = "maxLevel", required = false) Integer maxLevel) {
        List<Player> playerList = playerService.getFilteredPlayers(name, title, race, profession, after, before, banned, minExperience,
                maxExperience, minLevel, maxLevel);
        return playerList.size();
    }


    @PostMapping("/players")                                                                                          // Это составленная аннотация, которая действует как ярлык для @RequestMapping.
    public Player createPlayer(@RequestBody Player player){                                                              // Отображение тела запроса с аннотацией @RequestBody
        return playerService.createPlayer(player);
    }


    @GetMapping("/players/{id}")                                                                                      // Это составленная аннотация, которая действует как ярлык для @RequestMapping.
    public Player getPlayer(@PathVariable(value = "id") String id){
        return playerService.getPlayer(id);
    }


    @PostMapping("/players/{id}")                                                                                     // Это составленная аннотация, которая действует как ярлык для @RequestMapping.
    public Player updatePlayer(
            @PathVariable (value = "id") String id,                                                                      // Один из распространённых способов передачи параметров запроса — в виде частей адреса запроса.
            @RequestBody Player player){                                                                                 // Отображение тела запроса с аннотацией @RequestBody

        if (player.getName() == null && player.getTitle() == null && player.getProfession() == null && player.getRace()
                == null && player.getBirthday() == null && player.getExperience() == null)
            return playerService.getPlayer(id);

        return playerService.updatePlayer(player, playerService.getPlayer(id));
    }


    @DeleteMapping("/players/{id}")                                                                                   // Это составленная аннотация, которая действует как ярлык для @RequestMapping.
    public void deletePlayer(@PathVariable(value = "id")String id) {                                                     // Один из распространённых способов передачи параметров запроса — в виде частей адреса запроса.
        playerService.deletePlayer(playerService.getPlayer(id));
    }
}
