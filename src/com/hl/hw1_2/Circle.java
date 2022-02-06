package com.hl.hw1_2;

public class Circle {
    int centerX = 0;
    int centerY = 0;
    int R;

    public int getR() {
        return R;
    }

    public void setR(int r) {
        this.R = r;
    }

    public Circle() {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    void belonging(int currentX,int currentY) {
              if (new Point().distance(currentX,currentY) > R) {
                System.out.println("точка (" + currentX + "; " + currentY + ") находится вне окружности");
            } else {
                System.out.println("точка (" + currentX + "; " + currentY + ")  находится в окружности");
            }
        }
    }
