package com.arena.arena.service;

import com.arena.arena.model.Arena;
import com.arena.arena.model.UpdateArena;
import com.arena.arena.repository.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArenaServiceImpl implements ArenaService{
    @Autowired
    ArenaRepository repository;
    @Override
    public void create(Arena arena) {
        repository.save(arena);
    }

    @Override
    public void update(UpdateArena arena, UUID arenaid) {
        repository.updateArena(arenaid,arena.getHealth(),arena.getStrength(),arena.getAttack());
    }

    @Override
    public Arena getArenaDetails( UUID arenaId) {
        return repository.getArenaId(arenaId);
    }

    @Override
    public List<Arena> getAll() {
        return repository.getAll();
    }
}
