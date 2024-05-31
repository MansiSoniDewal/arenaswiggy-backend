package com.arena.arena.controller;

import com.arena.arena.model.Arena;
import com.arena.arena.model.UpdateArena;
import com.arena.arena.service.ArenaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/arena")
public class ArenaController {

    @Autowired
    ArenaService service;
    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestBody Arena arena, HttpServletRequest request){
        try{
            service.create(arena);
            return new ResponseEntity<>("arena created", HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{arenaId}")
    public ResponseEntity<?> updateCourse(@PathVariable UUID arenaId,
                                          @RequestBody UpdateArena arena )
    {
        try{
            service.update(arena,arenaId);
           return new ResponseEntity<>("arena Updated", HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getArenaById/{arenaId}")
    public ResponseEntity<?> getArenaById(@PathVariable UUID arenaId){
        try{
            Arena result=service.getArenaDetails(arenaId);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try{
            List<Arena> result=service.getAll();
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
