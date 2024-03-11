    public class EquilateralTriangle
    {
        private double sideLength;

        public EquilateralTriangle(double sideLength)
        {
            this.sideLength = sideLength;
        }

        public double getSideLength()
        {
            return sideLength;
        }

        public void setSideLength(double sideLength)
        {
            this.sideLength = sideLength;
        }

        public double calculatePerimeter()
        {
            return 3 * sideLength;
        }

        public double calculateArea()
        {
            return (Math.sqrt(3) / 4) * sideLength * sideLength;
        }

        public boolean isTriangleValid()
        {
            return sideLength > 0;
        }

        @Override
        public String toString()
        {
            return "EquilateralTriangle{" +
                    "sideLength=" + sideLength +
                    '}';
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            EquilateralTriangle other = (EquilateralTriangle) obj;
            return Double.compare(other.sideLength, sideLength) == 0;
        }
    }