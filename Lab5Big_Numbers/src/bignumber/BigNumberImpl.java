package bignumber;


public class BigNumberImpl implements BigNumber {
    private Node head;
    private Node tail;

   //Constructor
    public BigNumberImpl() {
        this.head = new Node();
        this.tail = this.head;
    }


    //Use a number as a String
    public BigNumberImpl(String number) throws IllegalArgumentException {
        this.head = new Node();
        this.tail = this.head;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            this.addDigit(c - '0');
            this.shiftLeft(1);
        }
        this.deleteEndNode();
    }

    //Add a new node at end of the list
    public void addEndNode() {
        Node newNode = new Node();
        if (this.tail.prev == null && this.tail.value == 0) {
            return;
        }
        this.tail.next = newNode;

        Node dummy = this.tail;
        this.tail = newNode;
        this.tail.prev = dummy;
    }


    //Delete the end of the node
    public void deleteEndNode() {
        if(this.tail!=this.head){
            this.tail = this.tail.prev;
            this.tail.next = null;

        }else{
            this.tail.value = 0;
        }
    }

    @Override
    public int length() {
        Node head = this.head;
        int counter = 1;

        while (head.next != null) {
            head = head.next;
            counter++;
        }

        return counter;
    }

    @Override
    public void shiftLeft(int shift) {
        if (shift >= 0) {
            for (int i = 0; i < shift; i++) {
                addEndNode();
            }
        } else {
            for (int i = 0; i < -shift; i++) {
                deleteEndNode();
            }
        }
    }

    @Override
    public void shiftRight(int shift) {
        if (shift >= 0) {
            for (int i = 0; i < shift; i++) {
                deleteEndNode();
            }
        } else {
            for (int i = 0; i < -shift; i++) {
                addEndNode();
            }
        }
    }

    @Override
    public void addDigit(int digit) throws IllegalArgumentException {
        if (digit >= 10 || digit < 0) {
            throw new IllegalArgumentException();
        } else {
            int total = this.tail.value + digit;
            if (total < 10) {
                this.tail.value = total;
            } else {
                Node ptr = this.tail;
                while (total >= 10) {
                    if (ptr == this.head) {
                        ptr.value = total % 10;
                        Node newNode = new Node();
                        newNode.value = 1;
                        this.head.prev = newNode;
                        newNode.next = this.head;
                        this.head = newNode;
                        break;
                    }

                    ptr.value = total % 10;
                    ptr.prev.value += 1;
                    total = ptr.prev.value;
                    ptr = ptr.prev;
                }
            }
        }
    }

    @Override
    public int getDigitAt(int position) throws IllegalArgumentException {
        if ( position < 0||position >= this.length()) {
            throw new IllegalArgumentException();
        }

        Node targetNode = this.tail;
        for (int i = 0; i < position; i++) {
            targetNode = targetNode.prev;
        }

        return targetNode.value;
    }

    @Override
    public BigNumber copy() {
        BigNumberImpl number = new BigNumberImpl();
        Node targetNode = this.head;
        while (targetNode != null) {
            number.addEndNode();
            number.addDigit(targetNode.value);
            targetNode = targetNode.next;
        }

        return number;
    }


    @Override
    public BigNumber add(BigNumber target) {
        BigNumberImpl newList = new BigNumberImpl();
        int difference = 0;
        if (this.length() > target.length()) {
            difference = this.length() - target.length();
            for (int i = 0; i < difference; i++) {
                newList.addDigit(this.getDigitAt(this.length() - i - 1));
                newList.shiftLeft(1);
            }
            for (int i = 0; i < target.length(); i++) {
                newList.addDigit(this.getDigitAt(target.length() - i - 1));
                newList.addDigit(target.getDigitAt(target.length() - i - 1));
                newList.shiftLeft(1);
            }
            newList.deleteEndNode();
        } else if (this.length() == target.length()) {
            for (int i = 0; i < target.length(); i++) {
                newList.addDigit(this.getDigitAt(this.length() - i - 1));
                newList.addDigit(target.getDigitAt(this.length() - i - 1));
                newList.shiftLeft(1);
            }
            newList.deleteEndNode();

        } else {
            difference = target.length() - this.length();
            for (int i = 0; i < difference; i++) {
                newList.addDigit(target.getDigitAt(target.length() - i - 1));
                newList.shiftLeft(1);
            }
            for (int i = 0; i < this.length(); i++) {
                newList.addDigit(target.getDigitAt(this.length() - i - 1));
                newList.addDigit(this.getDigitAt(this.length() - i - 1));
                newList.shiftLeft(1);
            }
            newList.deleteEndNode();
        }
        return newList;
    }

    @Override
    public int compareTo(BigNumber num1) {
        if (num1.length() == this.length()) {
            for (int i = 0; i < num1.length(); i++) {
                if (num1.getDigitAt(this.length() - i - 1)
                        < this.getDigitAt(this.length() - i - 1)) {
                    return 1;

                } else if (i == num1.length() - 1
                        && num1.getDigitAt(this.length() - i - 1)
                        == this.getDigitAt(this.length() - i - 1)) {
                    return 0;
                } else if (num1.getDigitAt(this.length() - i - 1)
                        > this.getDigitAt(this.length() - i - 1)) {
                    return -1;
                }
            }
        }
        return num1.length() > this.length() ? -1 : 1;
    }


    /**
     * Returns a string representation of this number, as simply the number itself.
     */
    @Override
    public String toString() {
        String num = "";
        Node head = this.head;
        while (head != null) {
            num += head.value;
            head = head.next;
        }

        return num;
    }
}
