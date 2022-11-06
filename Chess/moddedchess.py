import pygame

def main():
    pygame.init()
    # create a pygame display window
    chess_display = pygame.display.set_mode((768, 768))
    # set the title of the display window
    pygame.display.set_caption("Modded Chess")   
    # get the display surface
    
    chess_surface = pygame.image.load("Chess_Board.png")
    
    chess = Chess(chess_surface, chess_display)
    
    chess.play()
    
    pygame.quit()
    

    

class Chess:
    
    def __init__(self, surface, display):
        
        self.surface = surface
        
        self.display = display
        
        self.close_clicked = False
        
        # white pieces
        self.wpawn1 = Piece("pawn-w.png", ["a", 2])
        self.wpawn2 = Piece("pawn-w.png", ["b", 2])
        self.wpawn3 = Piece("pawn-w.png", ["c", 2])
        self.wpawn4 = Piece("pawn-w.png", ["d", 2])
        self.wpawn5 = Piece("pawn-w.png", ["e", 2])
        self.wpawn6 = Piece("pawn-w.png", ["f", 2])
        self.wpawn7 = Piece("pawn-w.png", ["g", 2])
        self.wpawn8 = Piece("pawn-w.png", ["h", 2])
        self.wrook1 = Piece("rook-w.png", ["a", 1])
        self.wnigh1 = Piece("knight-w.png", ["b", 1])
        self.wbish1 = Piece("bish-w.png", ["c", 1])
        self.wquee1 = Piece("queen-w.png", ["d", 1])
        self.wking1 = Piece("king-w.png", ["e", 1])
        self.wbish2 = Piece("bish-w.png", ["f", 1])
        self.wnigh2 = Piece("knight-w.png", ["g", 1])
        self.wrook2 = Piece("rook-w.png", ["h", 1])
        
        self.bpawn1 = Piece("pawn-b.png", ["a", 7])
        self.bpawn2 = Piece("pawn-b.png", ["b", 7])
        self.bpawn3 = Piece("pawn-b.png", ["c", 7])
        self.bpawn4 = Piece("pawn-b.png", ["d", 7])
        self.bpawn5 = Piece("pawn-b.png", ["e", 7])
        self.bpawn6 = Piece("pawn-b.png", ["f", 7])
        self.bpawn7 = Piece("pawn-b.png", ["g", 7])
        self.bpawn8 = Piece("pawn-b.png", ["h", 7])
        self.brook1 = Piece("rook-b.png", ["a", 8])
        self.bnigh1 = Piece("knight-b.png", ["b", 8])
        self.bbish1 = Piece("bish-b.png", ["c", 8])
        self.bquee1 = Piece("queen-b.png", ["d", 8])
        self.bking1 = Piece("king-b.png", ["e", 8])
        self.bbish2 = Piece("bish-b.png", ["f", 8])
        self.bnigh2 = Piece("knight-b.png", ["g", 8])
        self.brook2 = Piece("rook-b.png", ["h", 8])        
        
        

               
    def play(self):
        # Play the game until the player presses the close box.
        # - self is the Game that should be continued or not.

        while not self.close_clicked:  # until player clicks close box
            # play frame
            
            self.handle_events()
            self.draw()
            pygame.display.update()
            
            
            
    def handle_events(self):
        # Handle each user event by changing the game state appropriately.
        # - self is the Game whose events will be handled

        events = pygame.event.get()
        for event in events:
            if event.type == pygame.QUIT:
                self.close_clicked = True
                
            elif event.type == pygame.MOUSEBUTTONUP:
                pos = pygame.mouse.get_pos()
                self.handle_mouse_down(event, pos)
    
    def handle_mouse_down(self, event, pos):
        pass
        
    
    def draw(self):
        # Draw all game objects.
        # - self is the Game to draw

        self.display.blit(self.surface, (0,0)) # clear the display surface first    
        
        self.display.blits([(self.wpawn1.show_surface(), self.wpawn1.position_conv()),
                          (self.wpawn2.show_surface(), self.wpawn2.position_conv()),
                          (self.wpawn3.show_surface(), self.wpawn3.position_conv()),
                          (self.wpawn4.show_surface(), self.wpawn4.position_conv()),
                          (self.wpawn5.show_surface(), self.wpawn5.position_conv()),
                          (self.wpawn6.show_surface(), self.wpawn6.position_conv()),
                          (self.wpawn7.show_surface(), self.wpawn7.position_conv()),
                          (self.wpawn8.show_surface(), self.wpawn8.position_conv()),
                          (self.wrook1.show_surface(), self.wrook1.position_conv()),
                          (self.wnigh1.show_surface(), self.wnigh1.position_conv()),
                          (self.wbish1.show_surface(), self.wbish1.position_conv()),
                          (self.wquee1.show_surface(), self.wquee1.position_conv()),
                          (self.wking1.show_surface(), self.wking1.position_conv()),
                          (self.wbish2.show_surface(), self.wbish2.position_conv()),
                          (self.wnigh2.show_surface(), self.wnigh2.position_conv()),
                          (self.wrook2.show_surface(), self.wrook2.position_conv()),
                          (self.bpawn1.show_surface(), self.bpawn1.position_conv()),
                          (self.bpawn2.show_surface(), self.bpawn2.position_conv()),
                          (self.bpawn3.show_surface(), self.bpawn3.position_conv()),
                          (self.bpawn4.show_surface(), self.bpawn4.position_conv()),
                          (self.bpawn5.show_surface(), self.bpawn5.position_conv()),
                          (self.bpawn6.show_surface(), self.bpawn6.position_conv()),
                          (self.bpawn7.show_surface(), self.bpawn7.position_conv()),
                          (self.bpawn8.show_surface(), self.bpawn8.position_conv()),
                          (self.brook1.show_surface(), self.brook1.position_conv()),
                          (self.bnigh1.show_surface(), self.bnigh1.position_conv()),
                          (self.bbish1.show_surface(), self.bbish1.position_conv()),
                          (self.bquee1.show_surface(), self.bquee1.position_conv()),
                          (self.bking1.show_surface(), self.bking1.position_conv()),
                          (self.bbish2.show_surface(), self.bbish2.position_conv()),
                          (self.bnigh2.show_surface(), self.bnigh2.position_conv()),
                          (self.brook2.show_surface(), self.brook2.position_conv())])
 
class Piece:
    
    def __init__(self, piece, position):
        
        self.piece_surface = pygame.image.load(piece)
        
        self.position = position
        
        self.piece_side = 96
        
        self.piece_surface = pygame.transform.scale(self.piece_surface, (self.piece_side, self.piece_side))
        
        
        
    def show_surface(self):
        return self.piece_surface
        
    def position_conv(self):
        act_pos = []
        board_height = 768
        pos_key = ord("a")
        
        for pos in self.position:
            if isinstance(pos, str):
                horz_pos = (ord(pos) % pos_key) * self.piece_side # convert letter to x coord
                act_pos.append(horz_pos - 4) # -4 to centre the piece
            else:
                vert_pos = (pos - 1) * self.piece_side # start counting from 0
                vert_pos = board_height - vert_pos - self.piece_side # flip to cartesian
                act_pos.append(vert_pos)
                
        return act_pos 
    
    def piece_rect(self):
        
        return pygame.Rect(tuple(self.position_conv), (self.piece_side, self.piece_side))
   
if __name__ == "__main__":
    main()