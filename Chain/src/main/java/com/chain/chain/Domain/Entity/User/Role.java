package com.chain.chain.Domain.Entity.User;





   public enum Role{
        ADMIN("ADMIN"), USER("USER");
        private String role = "";

        Role(String role) {
            this.role = String.format("ROLE_%s", role);
        }

}
