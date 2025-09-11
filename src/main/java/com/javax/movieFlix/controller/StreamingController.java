package com.javax.movieFlix.controller;


import com.javax.movieFlix.controller.request.StreamingRequest;
import com.javax.movieFlix.controller.response.StreamingResponse;
import com.javax.movieFlix.entity.Streaming;
import com.javax.movieFlix.mapper.StreamingMapper;
import com.javax.movieFlix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {
    private final StreamingService streamingService;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAll(){
        return ResponseEntity.ok(streamingService
                .findAll()
                .stream()
                .map(StreamingMapper::toResponse)
                .toList()
        );
    }

   @PostMapping()
   public ResponseEntity<StreamingResponse> create (@RequestBody StreamingRequest streamingRequest){
       Streaming streaming = StreamingMapper.toStreaming(streamingRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toResponse(streamingService.save(streaming)));

   }

    @GetMapping("{id}")
    public ResponseEntity<StreamingResponse> getByID(@PathVariable Long id){
       return streamingService.findByID(id)
               .map(streaming ->  ResponseEntity.ok(StreamingMapper.toResponse(streaming)))
               .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID (@PathVariable Long id){
        streamingService.deleteByID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
