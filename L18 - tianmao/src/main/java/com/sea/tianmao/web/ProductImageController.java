package com.sea.tianmao.web;

import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.pojo.ProductImage;
import com.sea.tianmao.service.ProductImageService;
import com.sea.tianmao.service.ProductService;
import com.sea.tianmao.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductImageController {
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ProductService productService;

    @GetMapping("/products/{pid}/productImages")
    public List<ProductImage> list(@RequestParam("type") String type, @PathVariable("pid") int pid) throws Exception {
        Product product = productService.get(pid);
        if (productImageService.TYPE_SINGLE.equals(type)) {
            List<ProductImage> singles = productImageService.listSingleProductImages(product);
            return singles;
        } else if (productImageService.TYPE_DETAIL.equals(type)) {
            List<ProductImage> details = productImageService.listDetailProductImages(product);
            return details;
        } else {
            return new ArrayList<>();
        }
    }

    @PostMapping("/productImages")
    public Object add(@RequestParam("pid") int pid, @RequestParam("type") String type, MultipartFile image, HttpServletRequest request) throws Exception {
        ProductImage productImage = new ProductImage();
        Product product = productService.get(pid);
        productImage.setProduct(product);
        productImage.setType(type);
        productImageService.add(productImage);
        String folder = "img/";
        if (ProductImageService.TYPE_SINGLE.equals(productImage.getType()))
            folder += "productSingle";
        else
            folder += "productDetail";
        File imageFolder = new File(request.getServletContext().getRealPath(folder));
        File file = new File(imageFolder, productImage.getId() + ".jpg");
        String fileName = file.getName();
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try {
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (ProductImageService.TYPE_SINGLE.equals(productImage.getType())) {
            String imageFolderSmall = request.getServletContext().getRealPath("img/productSingleSmall");
            String imageFolderMiddle = request.getServletContext().getRealPath("img/productSingleMiddle");
            File fileSmall = new File(imageFolderSmall, fileName);
            File fileMiddle = new File(imageFolderMiddle, fileName);
            fileSmall.getParentFile().mkdirs();
            fileMiddle.getParentFile().mkdirs();
            ImageUtil.resizeImage(file, 56, 56, fileSmall);
            ImageUtil.resizeImage(file, 217, 190, fileMiddle);
        }
        return productImage;
    }

    @DeleteMapping("/productImages/{id}")
    public String delete(@PathVariable("id") int id) throws Exception {
        productImageService.delete(id);
        return null;
    }
}
