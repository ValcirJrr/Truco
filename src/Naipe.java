package src;

public enum Naipe {
    PAUS {
        @Override
        public byte valor() {
            return 4;
        }

        @Override
        public String toString() {
            return "♣";
        }
    },
    COPAS {
        @Override
        public byte valor() {
            return 3;
        }

        @Override
        public String toString() {
            return "♥";
        }

    },
    ESPADAS {
        @Override
        public byte valor() {
            return 2;
        }

        @Override
        public String toString() {
            return "♠";
        }

    },
    OUROS {
        @Override
        public byte valor() {
            return 1;
        }

        @Override
        public String toString() {
            return "♦";
        }

    };

    public abstract byte valor();

    @Override
    public abstract String toString();
}
