package com.example.FinalAssignment.controller;

import com.example.FinalAssignment.facade.AlbumFacade;
import com.example.FinalAssignment.model.dto.AlbumDto;
import com.example.FinalAssignment.model.param.AddAlbumParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumFacade albumFacade;

    @PostMapping("add-album")
    @PreAuthorize("hasRole('ARTIST')")
    @Operation(security = @SecurityRequirement(name = "bearer-token"))
    public ResponseEntity<AlbumDto> addAlbum(@RequestBody AddAlbumParam addAlbumParam) {
        return new ResponseEntity<>(albumFacade.addAlbum(addAlbumParam), HttpStatus.CREATED);
    }

}
