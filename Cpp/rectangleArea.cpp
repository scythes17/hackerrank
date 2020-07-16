#include <iostream>

using namespace std;
/*
 * Create classes Rectangle and RectangleArea
 */
class Rectangle {
    public:
        int width, height;
        virtual void display() const { // it's good practice to use const when dealing with inheritance
            cout << width << ' ' << height << '\n'; 
        }
};

class RectangleArea: public Rectangle {
    public:
        void read_input() {
            cin >> width >> height;
        }
        virtual void display() const override { // as display() was declared const, we have to override it
            int area = width*height;
            cout << area << endl;
        }
};

int main()
{
    /*
     * Declare a RectangleArea object
     */
    RectangleArea r_area;
    
    /*
     * Read the width and height
     */
    r_area.read_input();
    
    /*
     * Print the width and height
     */
    r_area.Rectangle::display();
    
    /*
     * Print the area
     */
    r_area.display();
    
    return 0;
}