package auto.freitagsmarkt.controller;

import auto.freitagsmarkt.dto.SellerDTO;
import auto.freitagsmarkt.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SellerController.SELLER_URI)
public class SellerController {
    public static final String SELLER_URI = "/api/seller";

    private SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/list-sellers")
    public ResponseEntity<List<SellerDTO>> listAllSeller(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok(sellerService.listSellers(page,size));
    }
    @GetMapping("/{sellerId}")
    public ResponseEntity<SellerDTO> findBySellerId(@PathVariable Long sellerId) {
        return ResponseEntity.ok(sellerService.findSellerById(sellerId));
    }
    @PostMapping
    public ResponseEntity<SellerDTO> addNewSeller(@RequestBody SellerDTO sellerDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.createNewSellerProfile(sellerDTO));
    }
    @PutMapping("/{sellerId}")
    public ResponseEntity<SellerDTO> updateSeller(@PathVariable Long sellerId, @RequestBody SellerDTO sellerDTO){
        return ResponseEntity.ok(sellerService.updateSeller(sellerId,sellerDTO));
    }
    @DeleteMapping("/{sellerId}")
    public ResponseEntity<String> deleteSellerById(@PathVariable Long sellerId){
        return (sellerService.removeSellerById(sellerId))?
                ResponseEntity.ok("Ad deleted successfully!!"):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seller with the given ID does not exist");
    }


}
