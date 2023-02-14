package com.example.projectweek5.Service;

import com.example.projectweek5.DTO.LocationDto;
import com.example.projectweek5.Exeption.Api;
import com.example.projectweek5.Model.Location;
import com.example.projectweek5.Model.Store;
import com.example.projectweek5.Repositry.LocationRepositry;
import com.example.projectweek5.Repositry.StoreRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final StoreRepositry storeRepositry;
    private final LocationRepositry locationRepositry;
    public void addadlocationDetals(LocationDto locationDto){
        Store store=storeRepositry.findStoreById(locationDto.getStore_id());
        if (store==null){
            throw new Api("store not found");

        }
        Location c= new Location(null, locationDto.getArea(), locationDto.getStreet(),store);
        locationRepositry.save(c);

    }

    public void UpdatelocationDetails(LocationDto LocationDto){
        Location k=locationRepositry.findLocationById(LocationDto.getStore_id());
        if (k==null){
            throw new Api("stoer not found");
        }
        k.setArea(LocationDto.getArea());
        k.setStreet(LocationDto.getStreet());

        locationRepositry.save(k);

    }

    public void deletelocationDetails(Integer id){
        Location l=locationRepositry.findLocationById(id);
        if (l==null){
            throw new Api("store not found");
        }
        locationRepositry.delete(l);
    }

    public Location getstoredetails(Integer id, LocationDto locationDto){
        Location L=locationRepositry.findLocationById(id);
        if (L==null){
            throw new Api("store not found");
        }

        return locationRepositry.findAllById(id);


    }
}
