package org.example.util;

import org.example.enums.ClotheCategory;
import org.example.enums.ClotheSize;
import org.example.enums.SaleStatus;

import java.util.InputMismatchException;

public abstract class EnumChecker {

    public static ClotheSize getSize(String size){
        switch (size){
            case "xs":
                return ClotheSize.XS;
            case "s":
                return ClotheSize.S;
            case "m":
                return ClotheSize.M;
            case "l":
                return ClotheSize.L;
            case "xl":
                return ClotheSize.XL;
                default:
                    throw new InputMismatchException("Choix invalide !");
        }
    }
    public static ClotheCategory getCategory(String category){
        switch (category){
            case "men":
                return ClotheCategory.MEN;
            case "women":
                return ClotheCategory.WOMEN;
            case "children" :
                return ClotheCategory.CHILDREN;
            default:
                throw new InputMismatchException("Choix invalide !");
        }
    }

    public static SaleStatus getSalesStatus(String status){
        switch (status){
            case "processed":
                return SaleStatus.PROCESSED;
            case "finished":
                return SaleStatus.FINISHED;
            case "canceled":
                return SaleStatus.CANCELLED;
            default:
                throw new InputMismatchException("Choix invalide !");
        }
    }
}
