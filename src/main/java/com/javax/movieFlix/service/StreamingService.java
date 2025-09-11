package com.javax.movieFlix.service;

import com.javax.movieFlix.entity.Streaming;
import com.javax.movieFlix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StreamingService {
    final private StreamingRepository streamingRepository;

    public List<Streaming> findAll(){
        return streamingRepository.findAll();
    }
    public Streaming save(Streaming streaming){
        return streamingRepository.save(streaming);
    }
    public Optional<Streaming> findByID(Long id){
        return streamingRepository.findById(id);
    }
    public void deleteByID(Long id){
        streamingRepository.deleteById(id);
    }
}
