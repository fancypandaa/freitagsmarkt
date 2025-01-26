package auto.cc.info.controllers;

import auto.cc.info.dto.SellerCommand;
import auto.cc.info.domain.user.Constants;
import auto.cc.info.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("/api/seller")
@Slf4j
public class SellerController {
    private SellerService sellerService;
    @Autowired
    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
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
    @RequestMapping(value = "/{sellerId}",method = RequestMethod.PATCH,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public SellerCommand updateSeller(@PathVariable Long sellerId, @RequestBody SellerCommand sellerCommand){
        SellerCommand sellerCommand1 = sellerService.updateSeller(sellerId,sellerCommand);
        return sellerCommand1;
    }
    @RequestMapping(value = "{sellerId}",method = RequestMethod.DELETE,produces = "application/json")
    @RolesAllowed(Constants.SELLER)
    public void deleteSellerById(@PathVariable Long sellerId){
        sellerService.removeSellerById(sellerId);
    }

    @QueryMapping("listAllSeller")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public Page<SellerCommand> listAllSeller(@Argument int page, @Argument int size){
        Page<SellerCommand> sellerCommands = sellerService.listSellers(page,size);
        return sellerCommands;
    }
    @QueryMapping(name = "findBySellerId")
    @RolesAllowed({Constants.USER,Constants.SELLER})
    public SellerCommand findBySellerId(@Argument Long id) {
        SellerCommand sellerCommand = sellerService.findSellerById(id);
        return sellerCommand;
    }
}
