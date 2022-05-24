package com.hl.hw21.task5;

import java.time.LocalDate;

public record Product(String type, double price, boolean discount, LocalDate createDate) {
}
