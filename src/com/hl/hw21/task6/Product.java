package com.hl.hw21.task6;

import java.time.LocalDate;

public record Product(int ID, String type, double price, boolean discount, LocalDate createDate) {
}
