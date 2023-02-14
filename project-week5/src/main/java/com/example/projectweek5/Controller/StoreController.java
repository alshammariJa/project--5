package com.example.projectweek5.Controller;

import com.example.projectweek5.DTO.LocationDto;
import com.example.projectweek5.Model.Location;
import com.example.projectweek5.Model.Store;
import com.example.projectweek5.Service.LocationService;
import com.example.projectweek5.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ap1/v1/store")
public class StoreController {
    private final StoreService storeService;
    private final LocationService locationService;

    @GetMapping("/get")
    public ResponseEntity getStore(){
     List<Store> stores= storeService.getStores();
        return ResponseEntity.status(200).body(stores);
    }
     @PostMapping("/add")
    public ResponseEntity addStore( @Valid @RequestBody Store store ){
        storeService.addStore(store);
        return ResponseEntity.status(200).body("added done!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStore( @Valid @PathVariable Integer id, @RequestBody Store store){
        storeService.updateStore(id,store);
        return ResponseEntity.status(200).body("update done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id){
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body("deleted done!");

    }
    @GetMapping("/getdetails/{id}")
    public ResponseEntity getTeacherdetails(@PathVariable Integer id,@RequestBody LocationDto locationDto){
        Location location=locationService.getstoredetails(id,locationDto);
        return ResponseEntity.status(200).body(location);
    }
    @GetMapping("/getallstoreinfo/{id}")
    public ResponseEntity getstoreinfo(@PathVariable Integer id){
        Store store=storeService.findStore(id);
        return ResponseEntity.status(200).body(store);
    }
    @GetMapping("/{storeId}/customers")
    public ResponseEntity getAllCustomersForStore(@PathVariable Integer storeId){
        return ResponseEntity.status(200).body(storeService.getAllCustomersForStore(storeId));
    }


}
