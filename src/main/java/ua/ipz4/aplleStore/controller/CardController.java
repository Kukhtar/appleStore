package ua.ipz4.aplleStore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.ipz4.aplleStore.dto.UserDto;
import ua.ipz4.aplleStore.model.Card;
import ua.ipz4.aplleStore.model.Product;
import ua.ipz4.aplleStore.model.UserModel;
import ua.ipz4.aplleStore.repository.ProductRepository;
import ua.ipz4.aplleStore.repository.UserRepo;

@RequestMapping("card")
@RequiredArgsConstructor
@RestController
public class CardController {

    private final ProductRepository productRepository;
    private final UserRepo userRepo;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Product> findAll(Pageable pageable) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = (UserModel) auth.getPrincipal();
        Card card = userModel.getCard();
        return new PageImpl<Product>(card.getProducts(), pageable, card.getProducts().size());
    }

    @PostMapping("addProduct")
    public Card addProduct(Long productId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = (UserModel) auth.getPrincipal();
        Card card = userModel.getCard();
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("No such product"));
        card.getProducts().add(product);
        userRepo.save(userModel);

        return card;
    }
}
