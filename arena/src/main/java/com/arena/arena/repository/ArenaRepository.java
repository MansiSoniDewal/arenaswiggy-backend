package com.arena.arena.repository;

import com.arena.arena.model.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ArenaRepository extends JpaRepository<Arena, UUID> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="UPDATE arena SET health=?2,strength=?3,attack=?4 where arenaid = ?1")
    void updateArena(UUID arenaId, int health,int strength,int attack);

    @Query(nativeQuery = true,value="Select * from arena where arenaid = ?1")
    Arena getArenaId(UUID arenaId);

    @Query(nativeQuery = true,value="Select * from arena")
    List<Arena> getAll();
}
