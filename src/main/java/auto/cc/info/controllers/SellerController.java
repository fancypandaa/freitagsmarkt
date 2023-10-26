package auto.cc.info.controllers;

import auto.cc.info.commands.SellerCommand;
import auto.cc.info.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/seller")
@Slf4j
public class SellerController {
    private SellerService sellerService;

    @Autowired
    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }
    @RequestMapping(value = "/car_list", method= RequestMethod.GET, produces = "application/json")
    public Page<SellerCommand> listAllSeller(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "10") int size){
        Page<SellerCommand> sellerCommands = sellerService.listSellers(page,size);
        return sellerCommands;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public SellerCommand addNewSeller(@RequestBody SellerCommand sellerCommand){
        Optional<SellerCommand> sellerCommandOptional = Optional.ofNullable(sellerService.createNewSellerProfile(sellerCommand));
        if(!sellerCommandOptional.isPresent()){
            log.error("Your new seller not added failed process !!!");
            return null;
        }
        else {
            return sellerCommandOptional.get();
        }
    }
}
