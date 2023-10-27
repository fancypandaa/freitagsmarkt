package auto.cc.info.controllers;

import auto.cc.info.commands.SellerCommand;
import auto.cc.info.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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
    @QueryMapping("listAllSeller")
    public Page<SellerCommand> listAllSeller(@Argument int page, @Argument int size){
        Page<SellerCommand> sellerCommands = sellerService.listSellers(page,size);
        return sellerCommands;
    }
}
