package com.enigmacamp.elibrary.controller;

import com.enigmacamp.elibrary.model.entity.Publisher;
import com.enigmacamp.elibrary.model.request.PublisherRequest;
import com.enigmacamp.elibrary.model.response.SuccessResponse;
import com.enigmacamp.elibrary.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publishers")
public class PublisherController    {
    @Autowired
    private PublisherService publisherService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity getAllPublisher() throws Exception{
        List<Publisher> publishers = publisherService.list();
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse<>("Success Get All Publisher Data",publishers)
        );
    }

    @GetMapping("/list-by-name/{name}")
    public ResponseEntity getAllPublisherByName(@PathVariable("name") String name) throws Exception{
        List<Publisher> publishers = publisherService.listByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse<>("Success Get All Publisher Data",publishers)
        );
    }

    @PostMapping
    public ResponseEntity createPublisher(@RequestBody PublisherRequest publisherRequest) throws Exception{
        Publisher newPublisher = modelMapper.map(publisherRequest,Publisher.class);
        Publisher result = publisherService.create(newPublisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success Created Publisher",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) throws Exception{
        Optional<Publisher> publisher = publisherService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get Publisher by id",publisher));
    }

    @GetMapping("/publisher/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name) throws Exception{
        Publisher publisher = publisherService.getByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get Publisher by id",publisher));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@RequestBody PublisherRequest publisherRequest,@PathVariable("id") Integer id) throws Exception{
        Publisher publisher = modelMapper.map(publisherRequest,Publisher.class);
        publisherService.update(publisher,id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Update Publisher by id",publisher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) throws Exception {
        publisherService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Delete Publisher",null));
    }
}
