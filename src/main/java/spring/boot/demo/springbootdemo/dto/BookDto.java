package spring.boot.demo.springbootdemo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDto {
    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private Double price;

    @NotNull
    @NotEmpty
    private Integer year;

    public BookDto(@NotNull @NotEmpty String title,
                   @NotNull @NotEmpty Double price, @NotNull @NotEmpty Integer year) {
        this.title = title;
        this.price = price;
        this.year = year;
    }
}
