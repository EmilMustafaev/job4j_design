package ru.job4j.lsp.violation;

class AccessControl {
    /*
    Нарушение: ослабление постусловия, в базовом классе только администраторы получают
    доступ, а в наследнике условие ослабляетя и доступ получают все пользователи.
     */
    public boolean grantAccess(String userRole) {
        if (userRole.equals("ADMIN")) {
            return true;
        }
        return false;
    }
}

class PublicAccessControl extends AccessControl {
    @Override
    public boolean grantAccess(String userRole) {
        return true;
    }
}
