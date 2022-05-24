package com.hl.hw21.task4;

import java.time.LocalDate;

public record Product(String type, double price, boolean discount, LocalDate createDate) {
}
